package com.novachess;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {
    @Override
    public EntityModel<User> toModel(User user) {
        return EntityModel.of(user,
            linkTo(methodOn(UserController.class).one(user.getEmail())).withSelfRel(),
            linkTo(methodOn(PuzzleController.class).one(user.getCurrentPuzzleId())).withRel("currentPuzzle"),
            linkTo(methodOn(UserController.class).all()).withRel("users"));
    }
}