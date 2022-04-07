package horizure.micro.finance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




import horizure.micro.finance.entities.Comment;

import horizure.micro.finance.services.ICommentService;

@RestController
@RequestMapping("comment")
public class CommentController {

	@Autowired
	ICommentService icommentService;
	
	@GetMapping("/list-comments")
	@ResponseBody
	public List<Comment> getAllAccounts(){
		return icommentService.retrieveComments();
	}
	
	@PostMapping("/add-comment")
	@ResponseBody
	public Comment addComment(@RequestBody Comment c) {
		return icommentService.addComment(c);
	}
	
	@PutMapping("/edit-comment/{id}")
	@ResponseBody
	public Comment editComment(@PathVariable("id") Long id,@RequestBody Comment c) {
		return icommentService.updateComment(c);
	}
	

	@GetMapping("/get-comment/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_AGENT')")
	@ResponseBody
	public Comment getComment(@PathVariable("id") Long id){
		return icommentService.getComment(id);
	}
	
	
	@DeleteMapping("/delete-comment/{id}")
	@ResponseBody
	public void deleteComment(@PathVariable("id") Long id) {
		icommentService.removeComment(id);
	}
	
	
	@GetMapping("/get-nbcommentsbyreplyid/{id}")
	@ResponseBody
   public int getNbCommentsByReplyID(Long id) {
	
	
		return icommentService.getNbCommentsByReplyID(id);
	
	}	
	
	
	
	
	
	
}

	
	
	
	
	
	

