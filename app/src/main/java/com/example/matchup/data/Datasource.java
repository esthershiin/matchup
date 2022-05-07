package com.example.matchup.data;
import com.example.matchup.model.Game;
import com.example.matchup.R;

import java.io.Serializable;
import java.util.ArrayList;

public class Datasource implements Serializable {

    public Game bball1 = new Game("basketball", "BasketBall Game", "vyip123", "beginner", 0.1, "RSF", "4/15/22", 0, "6pm", 5, "1v1 tournament style", false);
    public Game bball2 = new Game("basketball", "March Madness Tournament", "johnysmiles", "intermediate", 0.5, "Tepid Park", "5/15/22", 15, "4pm", 25, "Tournament for intermediate players. Everyone welcome", false);
    public Game bball3 = new Game("basketball", "HORSE", "amanzasmith", "beginner", 0.8, "Linden Park", "4/25/22", 1, "4pm", 8, "Casual players playing some games like HORSE!", false);

    public Game soccer1 = new Game("soccer", "Soccer Game at Durk Field", "eshin15", "advanced", 0.15, "Durk Field", "4/25/22", 1, "4pm", 8, "Fun games chill vibes. Come thru", false);
    public Game soccer2 = new Game();

    public Game volleyball1 = new Game("volleyball", "Beach Volleyball", "provolleygirl", "advanced", 0.15, "Sandy Hook", "4/25/22", 1, "4pm", 5, "Advanced players only", false);

    public Game tennis1 = new Game("tennis", "Tennis Game @ Hearst", "tennisboy_2", "beginner", 0.15, "Country Courts", "4/25/22", 1, "4pm", 2, "1v1 scrims", false);

    public static ArrayList<Game> allGamesList;

    public ArrayList<Game> initializeGames() {
        allGamesList = new ArrayList<Game>();
        allGamesList.add(bball1);
        allGamesList.add(bball2);
        allGamesList.add(bball3);
        allGamesList.add(soccer1);
        allGamesList.add(soccer2);
        allGamesList.add(volleyball1);
        allGamesList.add(tennis1);
        return allGamesList;
    }

    public ArrayList<Game> loadAllGames() {
        return allGamesList;
    }

    public void addGame(Game game) {
        allGamesList.add(game);
    }

    public ArrayList<Game> loadBasketBallGames(boolean showJoined) {
        ArrayList<Game> gamesList = new ArrayList<Game>();
        ArrayList<Game> games = loadAllGames();
        for (Game game: games ) {
            if (game.type.equals("basketball") && game.joined == showJoined) {
                gamesList.add(game);
            }
        }
        return gamesList;
    }

    public ArrayList<Game> loadVolleyBallGames(boolean showJoined) {
        ArrayList<Game> gamesList = new ArrayList<Game>();
        ArrayList<Game> games = loadAllGames();
        for (Game game: games ) {
            if (game.type.equals("volleyball") && game.joined == showJoined) {
                gamesList.add(game);
            }
        }
        return gamesList;
    }

    public ArrayList<Game> loadSoccerGames(boolean showJoined) {
        ArrayList<Game> gamesList = new ArrayList<Game>();
        ArrayList<Game> games = loadAllGames();
        for (Game game: games ) {
            if (game.type.equals("soccer") && game.joined == showJoined) {
                gamesList.add(game);
            }
        }
        return gamesList;
    }

    public ArrayList<Game> loadTennisGames(boolean showJoined) {
        ArrayList<Game> gamesList = new ArrayList<Game>();
        ArrayList<Game> games = loadAllGames();
        for (Game game: games ) {
            if (game.type.equals("tennis") && game.joined == showJoined) {
                gamesList.add(game);
            }
        }
        return gamesList;
    }

    public ArrayList<Game> loadDiscoverGames() {
        ArrayList<Game> gamesList = new ArrayList<Game>();
        ArrayList<Game> games = loadAllGames();
        for (Game game: games ) {
            if (!game.joined) {
                gamesList.add(game);
            }
        }
        return gamesList;
    }

    public ArrayList<Game> loadJoinedGames() {
        ArrayList<Game> gamesList = new ArrayList<Game>();
        ArrayList<Game> games = loadAllGames();
        for (Game game: games ) {
            if (game.joined) {
                gamesList.add(game);
            }
        }
        return gamesList;
    }


}
