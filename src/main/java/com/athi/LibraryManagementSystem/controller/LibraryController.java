package com.athi.LibraryManagementSystem.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.athi.LibraryManagementSystem.model.Author;
import com.athi.LibraryManagementSystem.model.Book;
import com.athi.LibraryManagementSystem.model.Librarian;
import com.athi.LibraryManagementSystem.service.AuthorService;
import com.athi.LibraryManagementSystem.service.BookService;
import com.athi.LibraryManagementSystem.service.LibrarianService;
import com.athi.LibraryManagementSystem.service.MemberService;
import com.athi.LibraryManagementSystem.service.TransactionService;


@Controller
public class LibraryController {

	@Autowired
	private AuthorService authorService;

	@Autowired
	private BookService bookService;

	@Autowired
	private LibrarianService librarianService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/")
	public String home(HttpServletRequest request) {
		String redirectPage = "/html/MainPage";
		if (request.getSession().getAttribute("username") != null
				&& request.getSession().getAttribute("librarianId") != null) {
			redirectPage = "/html/Home";
		}
		return redirectPage;
	}

	@GetMapping("/createanaccount")
	public String invokeRegisteration(Model model) {
		model.addAttribute("librarian", new Librarian());
		return "/html/SignUp";
	}

	@PostMapping("/signup")
	public String registerAUser(@ModelAttribute("librarian") Librarian librarian) {
		String returnURL = "";
		try {
			if (librarianService.register(librarian)) {
				returnURL = "/html/SignIn";
			} else {
				returnURL = "/html/SignUp";
			}
		} catch (Exception exception) {
			returnURL = "/html/SignUp";
			exception.printStackTrace();
		}
		return returnURL;
	}

	@PostMapping("/isValidLicense")
	public ResponseEntity<String> invokeRegisteration(@RequestBody String inputJsonString) {
		boolean isValid = false;
		JSONObject jsonObject = null;
		try {
			if (inputJsonString != null && inputJsonString != "") {
				jsonObject = new JSONObject(inputJsonString);
				if (jsonObject.has("licenseKey")) {
					isValid = librarianService.isValidLicense(jsonObject.getString("licenseKey"));
				}
			}
		} catch (Exception exception) {
			isValid = false;
			exception.printStackTrace();
		}
		return new ResponseEntity<String>(Boolean.toString(isValid), HttpStatus.OK);
	}

	@GetMapping("/signin")
	public String signIn(Model model) {
		model.addAttribute("librarian", new Librarian());
		return "/html/SignIn";
	}
	
	@GetMapping("/signout")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}

	@PostMapping("/home")
	public String authenticateUser(@ModelAttribute("librarian") Librarian librarian, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		int librarianId = 0;
		String redirectPath = "/html/SignIn";
		try {
			librarianId = librarianService.getLibrarianId(librarian);
			if (librarianId > 0) {
				request.getSession().setAttribute("username", librarian.getUsername());
				request.getSession().setAttribute("librarianId", librarianId);
				redirectPath = "/html/Home";
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return redirectPath;
	}
	
	@GetMapping("/home/addauthor")
	public String addAuthor(Model model) {
		model.addAttribute("author", new Author());
		return "/html/AddAuthor";
	}
	
	@PostMapping("/home/registerauthor")
	public String registerAuthor(@ModelAttribute("author") Author author, HttpServletRequest request) {
		String redirectPath = "redirect:/home/addauthor";
		int librarianId = 0;
		try {
			librarianId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("librarianId")));
			if(librarianId>0) {
				authorService.registerAuthor(author, librarianId);
			} 
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return redirectPath;
	}
	
	@GetMapping("/home/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "/html/AddBook";
	}
	
	@PostMapping("/home/registerbook")
	public String registerBook(@ModelAttribute("book") Book book, HttpServletRequest request) {
		String redirectPath = "redirect:/home/addbook";
		int librarianId = 0;
		Author author = null;
		Date date = null;
		try {
			librarianId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("librarianId")));
			if(librarianId>0) {
				author = new Author();
				date = new SimpleDateFormat("yyyy-MM-dd").parse(book.getDateOfPurchaseString());
				author.setAuthorName(book.getAuthorName());
				author.setSectionCode(book.getSectionCode());
				author.setCreatedBy(librarianId);
				author.setLastModifiedBy(librarianId);
				author.setCreatedOn(System.currentTimeMillis());
				author.setLastModifiedOn(System.currentTimeMillis());
				book.setAuthorId(authorService.getAuthorId(author));
				author.setAuthorId(book.getAuthorId());
				if(author.getAuthorId()==0) {
					book.setAuthor(author);
				}
				book.setDataOfPurchase(date);
				bookService.registerBook(book, librarianId);
			} 
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return redirectPath;
	}
	
	@GetMapping("/home/viewallauthors")
	public String viewAllAuthors(Model model, HttpServletRequest request) {
		List<Author> authorList = authorService.fetchAuthors();
		model.addAttribute("author",new Author());
		for(Author author : authorList) {
			author.setBookCount(authorService.fetchBookCount(author.getAuthorId()));
		}
		model.addAttribute("authorsList",authorList);
		return "/html/AuthorList";
	}
	
	@PostMapping("/home/listauthoraction")
	public String listAuthorAction(@ModelAttribute("author") Author author, HttpServletRequest request) {
		String redirectUrl = "redirect:/home/viewallauthors";
		try {
			if("View".equals(author.getActionType()) && author.getViewList().length>0){
				request.getSession().setAttribute("selectedAuthorId", author.getViewList()[0]);
				redirectUrl = "redirect:/home/viewselectedbooks";
			} else if("Delete".equals(author.getActionType()) && author.getDeleteList().length>0) {
				for(Integer id : author.getDeleteList()) {
					bookService.deleteBooks(id);
					authorService.deleteAuthorById(id);
				}
			}
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		return redirectUrl;
	}
	
	@GetMapping("/home/viewselectedbooks")
	public String viewSelectedBooks(Model model, HttpServletRequest request) {
		List<Book> bookList = bookService.fetchBooks(Integer.valueOf(String.valueOf(request.getSession().getAttribute("selectedAuthorId"))));
		model.addAttribute("book",new Book());
		model.addAttribute("bookList",bookList);
		return "/html/BookList";
	}
	
	@GetMapping("/home/viewallbooks")
	public String viewAllBooks(Model model, HttpServletRequest request) {
		List<Book> bookList = bookService.fetchAllBooks();
		model.addAttribute("book",new Book());
		model.addAttribute("bookList",bookList);
		return "/html/BookList";
	}
	
	@PostMapping("/home/listbookaction")
	public String listBookAction(@ModelAttribute("book") Book book) {
		String redirectUrl = "redirect:/home/viewallbooks";
		try {
			bookService.deleteBooks(book.getDeleteList());
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		return redirectUrl;
	}
	
	@GetMapping("/home/searchbooks")
	public String searchBooks(Model model) {
		model.addAttribute("book", new Book());
		return "/html/SearchBooks";
	}
	
	@PostMapping("/home/searchBooksByName")
	public String searchBooksByName(@ModelAttribute("book") Book book, HttpServletRequest request) {
		String redirectPath = "redirect:/home/searchResult";
		try {
			request.getSession().setAttribute("BookList", bookService.searchBooks(book.getBookName()));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return redirectPath;
	}
	
	@GetMapping("/home/searchResult")
	@SuppressWarnings("unchecked")
	public String searchResult(Model model, HttpServletRequest request) {
		List<Book> bookList = (List<Book>) request.getSession().getAttribute("BookList");
		if(bookList == null) {
			bookList = new ArrayList<>();
		}
		model.addAttribute("book",new Book());
		model.addAttribute("bookList",bookList);
		return "/html/BookList";
	}

}
