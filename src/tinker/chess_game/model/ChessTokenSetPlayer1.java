package tinker.chess_game.model;

import tinker.chess_game.model.token.*;
import tinker.chess_game.view_controller.ChessGame.Player;

import java.util.ArrayList;
import java.util.List;

public class ChessTokenSetPlayer1 {
    private Player player;
    private List<ChessToken> tokenSet;

    public ChessTokenSetPlayer1(Player player) {
        this.player = player;
        tokenSet = new ArrayList<ChessToken>(16);

        initTokenSet();
    }

    private void initTokenSet() {
        // Local variable to store ChessToken object to be instantiated before being added to the ArrayList called tokenSet.
        ChessToken chessToken;

        // Instantiate 8 Pawn objects using the player it belongs to and its coordinate point, then store in tokenSet.
        int x = 0;
        int y = 420;
        for (int i = 0; i < 8; i++) {
            chessToken = new Pawn(player, x, y);
            tokenSet.add(chessToken);

            x += Tile.WIDTHBORDER;
        }

        // Instantiate 2 Rook objects using the player it belongs to and its coordinate point, then store in tokenSet.
        chessToken = new Rook(player, 0, 490);
        tokenSet.add(chessToken);
        chessToken = new Rook(player, 490, 490);
        tokenSet.add(chessToken);

        // Instantiate 2 Knight objects using the player it belongs to and its coordinate point, then store in tokenSet.
        chessToken = new Knight(player, 70, 490);
        tokenSet.add(chessToken);
        chessToken = new Knight(player, 420, 490);
        tokenSet.add(chessToken);

        // Instantiate 2 Bishop objects using the player it belongs to and its coordinate point, then store in tokenSet.
        chessToken = new Bishop(player, 140, 490);
        tokenSet.add(chessToken);
        chessToken = new Bishop(player, 350, 490);
        tokenSet.add(chessToken);

        // Instantiate 1 Queen object using the player it belongs to and its coordinate point, then store in tokenSet.
        chessToken = new Queen(player, 210, 490);
        tokenSet.add(chessToken);

        // Instantiate 1 King object using the player it belongs to and its coordinate point, then store in tokenSet.
        chessToken = new King(player, 280, 490);
        tokenSet.add(chessToken);
    }

    public Player getPlayer() {
        return player;
    }

    public List<ChessToken> getTokenSet() {
        return tokenSet;
    }
}
