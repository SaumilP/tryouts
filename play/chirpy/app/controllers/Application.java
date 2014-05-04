package controllers;


import play.mvc.*;

import com.fasterxml.jackson.databind.JsonNode;

import models.*;

public class Application extends Controller {

    /**
     * Display the home page.
     */
    public static Result index() {
        return ok(views.html.index.render());
    }

    /**
     * Display the chat room.
     *
     * @param  username Supplied Display Name
     * @return Result
     */
    public static Result chatRoom(String username) {
        if(username == null || username.trim().equals("")) {
            flash("error", "Please choose a valid username.");
            return redirect(routes.Application.index());
        }
        return ok(views.html.chatRoom.render(username));
    }

    public static Result chatRoomJs(String username) {
        return ok(views.js.chatRoom.render(username));
    }

    /**
     * Handle the chat websocket.
     */
    public static WebSocket<JsonNode> chat(final String username) {
        return new WebSocket<JsonNode>() {

            // Called when the Websocket Handshake is done.
            public void onReady(WebSocket.In<JsonNode> in, WebSocket.Out<JsonNode> out){

                // Join the chat room.
                try {
                    ChatRoom.join(username, in, out);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
    }

}