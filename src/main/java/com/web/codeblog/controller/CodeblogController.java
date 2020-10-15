package com.web.codeblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

import com.web.codeblog.model.Post;
import com.web.codeblog.service.CodeblogService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CodeblogController {

	@Autowired
	CodeblogService codeblogService;

	@RequestMapping(value = "/", method = RequestMethod.GET) //basicamente é o link que o usuario acessa
	public ModelAndView getPostsHome() { // Metodo adicionado para quando o "/" for acessado mostrar os POSTS
		ModelAndView mv = new ModelAndView("posts"); //PAGINA HTML POSTS
		List<Post> posts = codeblogService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET) //basicamente é o link que o usuario acessa
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts"); //PAGINA HTML POSTS
		List<Post> posts = codeblogService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails"); //OUTRA PAGINA HTML, Isso insere a pagina
		Post post = codeblogService.findById(id); // pegando os posts do service
		mv.addObject("post", post);
		return mv;
	}

	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public String getPostForm(){ //acessar o formulario para cadastrar um post
		return "postForm";
	}

	@RequestMapping(value="/newpost", method=RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        codeblogService.save(post);
        return "redirect:/posts";
    }
}
