package rollit;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Main {
    public static void main(String[] args) {
        final int boardWidth = 8;
        final int boardHeight = 8;
        //kheb heel de main herschreven
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        boolean gameLoop = true;
        while (gameLoop) {
            String Answer;
            int amountOfPlayers = 0;
            boolean looping = true;
            while (looping) {

                System.out.println("met hoeveel spelers wil je spelen (type 1 als je scores wil zien, type 0 als je de game wilt sluiten)");
                Answer = sc.nextLine();
                try {
                    amountOfPlayers = Integer.parseInt(Answer);
                    if (amountOfPlayers < 0) {
                        System.out.println("te weinig spelers");
                    } else if (amountOfPlayers > 4) {
                        System.out.println("te veel spelers");

                    } else {
                        looping = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("geen getal");
                }
            }
            boolean sessionLoop = false;
            switch (amountOfPlayers) {
                case 0 -> {
                    gameLoop = false;
                }
                case 1 -> {
                    System.out.println(menu.showHighScores());
                }

                case 2 -> {
                    System.out.println("wat is de naam van speler 1");
                    String name1 = sc.nextLine();
                    System.out.println("wat is de naam van speler 2");
                    String name2 = sc.nextLine();
                    menu.start2player(boardWidth, boardHeight, name1, name2);
                    System.out.println(name1 + " speelt met " + menu.getSession().getPlayer(0).getColor().toString() + "(" + menu.getSession().getPlayer(0).getColor().getChar() + ")");
                    System.out.println(name2 + " speelt met " + menu.getSession().getPlayer(1).getColor().toString() + "(" + menu.getSession().getPlayer(1).getColor().getChar() + ")");
                    sessionLoop = true;
                }

                case 3 -> {
                    System.out.println("wat is de naam van speler 1");
                    String name1 = sc.nextLine();
                    System.out.println("wat is de naam van speler 2");
                    String name2 = sc.nextLine();
                    System.out.println("wat is de naam van speler 3");
                    String name3 = sc.nextLine();
                    menu.start3player(boardWidth, boardHeight, name1, name2, name3);
                    System.out.println(name1 + " speelt met " + menu.getSession().getPlayer(0).getColor().toString() + "(" + menu.getSession().getPlayer(0).getColor().getChar() + ")");
                    System.out.println(name2 + " speelt met " + menu.getSession().getPlayer(1).getColor().toString() + "(" + menu.getSession().getPlayer(1).getColor().getChar() + ")");
                    System.out.println(name3 + " speelt met " + menu.getSession().getPlayer(2).getColor().toString() + "(" + menu.getSession().getPlayer(2).getColor().getChar() + ")");

                    sessionLoop = true;
                }

                case 4 -> {
                    System.out.println("wat is de naam van speler 1");
                    String name1 = sc.nextLine();
                    System.out.println("wat is de naam van speler 2");
                    String name2 = sc.nextLine();
                    System.out.println("wat is de naam van speler 3");
                    String name3 = sc.nextLine();
                    System.out.println("wat is de naam van speler 4");
                    String name4 = sc.nextLine();
                    menu.start4player(boardWidth, boardHeight, name1, name2, name3, name4);
                    System.out.println(name1 + " speelt met " + menu.getSession().getPlayer(0).getColor().toString() + "(" + menu.getSession().getPlayer(0).getColor().getChar() + ")");
                    System.out.println(name2 + " speelt met " + menu.getSession().getPlayer(1).getColor().toString() + "(" + menu.getSession().getPlayer(1).getColor().getChar() + ")");
                    System.out.println(name3 + " speelt met " + menu.getSession().getPlayer(2).getColor().toString() + "(" + menu.getSession().getPlayer(2).getColor().getChar() + ")");
                    System.out.println(name4 + " speelt met " + menu.getSession().getPlayer(3).getColor().toString() + "(" + menu.getSession().getPlayer(3).getColor().getChar() + ")");

                    sessionLoop = true;
                }

                default -> throw new IllegalArgumentException("illigal amount of players");


            }
            while (sessionLoop) {
                GameSession session = menu.getSession();
                System.out.println(session.getTurnNumber());
                Board board = session.getBoard();


                System.out.println(board.toString());
                System.out.println("het is aan " + session.getCurrent().getName()+" ("+session.getCurrent().getColor().getChar()+")");
                looping = true;

                while (looping) {
                    System.out.println("waar wil jij plaatsen (fomaat x,y)");
                    String answer = sc.nextLine();
                    int commas = 0;
                    for (int i = 0; i < answer.length(); i++) {
                        if (answer.charAt(i) == ',') commas++;
                    }
                    if (commas == 1) {
                        String[] split = answer.split(",");
                        boolean secondLegalCheck = true;
                        int x = 0;
                        int y = 0;
                        try {
                            x = Integer.parseInt(split[0]);
                        } catch (NumberFormatException e) {
                            System.out.println("x is geen getal");
                            secondLegalCheck = false;
                        } catch (ArrayIndexOutOfBoundsException A) {
                            System.out.println("x heeft geen waarde");
                            secondLegalCheck=false;
                        }

                        try {
                            y = Integer.parseInt(split[1]);
                        } catch (NumberFormatException e) {
                            System.out.println("y is geen getal");
                            secondLegalCheck = false;
                        }
                        catch (ArrayIndexOutOfBoundsException A) {
                            System.out.println("y heeft geen waarde");
                            secondLegalCheck = false;
                        }

                        if (secondLegalCheck) {
                            Coordinate coordinate = new Coordinate(x, y);
                            Move move = new Move(coordinate, session.getCurrent().getColor(), board);
                            if (move.checkLegal()) {
                                session.Play(coordinate);
                                looping = false;
                            } else System.out.println("illigal move");
                        }


                    } else System.out.println("fout aantal commas");
                }
            }
        }
    }
}
