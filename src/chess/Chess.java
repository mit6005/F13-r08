package chess;


public class Chess {

    /**
     * Player represents a poker player
     */
    public interface Player {
        /**
         * @return the skill of this player; higher is better.
         */
        public int skill();
    }
    
    /**
     * Tournament represents a poker tournament.
     */
    public interface Tournament {
        /**
         * @return the winner of the tournament -- a player whose skill is greater than or equal to 
         * all the other players in the tournament.
         */
        public Player winner();
    }
    
    //
    // 1. Write a recursive datatype definition for Tournament.  It should have 2 variants in its
    //    representation.
    //
    //         Tournament = Bye(p:Player) 
    //                      + Game(t1:Tournament, t2:Tournament)
    //
    // 2. Write winner() as a function over a Tournament, with one case for each variant.
    //
    //         winner: Tournament -> Player
    //            winner(Bye(p)) = p
    //            winner(Game(t1, t2)) = winner(t1) if skill(winner(t1)) >= skill(winner(t2))
    //                                   winner(t2) otherwise
    //
    
    // The classes below implement this representation of Tournaments.
    public static class Bye implements Tournament {
        private final Player player;
        
        public Bye(Player player) {
            this.player = player;
        }
        
        public Player winner() {
            return player;  // only one player in this tournament! lucky winner
        }
    }
    
    public static class Game implements Tournament {
        private final Tournament t1, t2;
        
        public Game(Tournament t1, Tournament t2) {
            this.t1 = t1;
            this.t2 = t2;
        }
        
        public Player winner() {
            Player w1 = t1.winner();
            Player w2 = t2.winner();
            if (w1.skill() >= w2.skill()) {
                return w1;
            } else {
                return w2;
            }
        }
    }
    

    
}
