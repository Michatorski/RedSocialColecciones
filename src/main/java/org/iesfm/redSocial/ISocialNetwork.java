package org.iesfm.redSocial;

import org.iesfm.redSocial.exceptions.UserNotFoundException;

import java.util.HashMap;
import java.util.TreeSet;

public interface ISocialNetwork {

    /**
     * Dado un username, devuelve los posts del muro de ese usuario.
     * @param username
     * @return post
     */
    TreeSet< Post> getWallPosts (String username) throws UserNotFoundException;

    /**
     * Dado un username y una etiqueta, devuelve los posts
     * del muro de ese usuario que tengan esa etiqueta.
     * @param username
     * @param tag
     * @return post
     */
    TreeSet< Post> getWallPosts (String username, String tag);

    /**
     * Dado un username, un mensaje, una fecha y unas etiquetas,
     * añada un post en el propio muro del usuario.
     * @param username
     * @param tag
     * @param date
     * @return post
     */
    TreeSet< Post> insertPosts (String username, String tag, String date);

    /**
     * Dado un username, busque todos los posts de los que es autor
     * en los diferentes muros y los devuelva en una lista.
     * @param username
     * @return post
     */
    TreeSet< Post> listPosts (String username);
}
