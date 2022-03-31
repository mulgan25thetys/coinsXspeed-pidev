package horizure.micro.finance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.Reaction;
import horizure.micro.finance.repositories.ReactionRepositry;
import horizure.micro.finance.services.ReactionSerice;

@RestController
public class ReactionRest {
	@Autowired
	ReactionSerice reactionSerice;
	@Autowired
	ReactionRepositry reactionRepositry;
	@PutMapping("/addLike/{idPost}/{idUser}")
	public void addLike(@RequestBody Reaction reaction, @PathVariable("id_Post") int idPost, @PathVariable("id_User") int idUser){
		reactionSerice.addLike(reaction,idPost, idUser);}
		@PutMapping("/addDislike/{idPost}/{idUser}")
		public void addDislike(@RequestBody Reaction reaction, @PathVariable("idPost") int idPost, @PathVariable("idUser") int idUser){
			reactionSerice.addDislike(reaction, idPost, idUser);}
			@PutMapping("/addSignal/{idPost}/{idUser}")
			public void addSignal(@RequestBody Reaction reaction, @PathVariable("idPost") int idPost, @PathVariable("idUser") int idUser){
				reactionSerice.addSignal(reaction, idPost, idUser);
			}
			@PutMapping("/addLikeAcomment/{idComment}/{idUser}")
			public void addLikeAcomment(@RequestBody Reaction reaction, @PathVariable("idComment") int idComment, @PathVariable("idUser") int idUser){
				reactionSerice.addLikeAcomment(reaction, idComment, idUser);
			}
			@PutMapping("/addSignalAcomment/{idComment}/{idUser}")
			public void addSignalAcomment(@RequestBody Reaction reaction, @PathVariable("idComment") int idComment, @PathVariable("idUser") int idUser){
				reactionSerice.addSignalAcomment(reaction, idComment, idUser);
			}

		

}
