package ViewModel;

import Model.IModel;
import Model.MyModel;
import algorithms.mazeGenerators.Maze;

import algorithms.search.SearchableMaze;
import algorithms.search.Solution;

import java.net.Socket;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class MyViewModel extends Observable implements Observer {
    private IModel model;

    public MyViewModel(IModel model) {

        this.model = model;
        model.assignObserver(this);
    }


    public void generateMaze(int row,int col){
        model.generateGame(row,col);
    }

    public void closeProgram() {
        model.closeProgram();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof IModel){
            if (arg instanceof Maze){
                setChanged();
                notifyObservers(arg);
            }

            else if (arg instanceof Solution){
                setChanged();
                notifyObservers(arg);
            }

            else{
                setChanged();
                notifyObservers(arg);
            }


        }
    }

    public void solveMaze() {
        model.solveGame();
    }
    public void getLoadGames(){
        ((MyModel)this.model).getLoadGames();
    }
    public void saveGame(){
        this.model.saveGame();
    }
}
