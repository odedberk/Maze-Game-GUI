package ViewModel;

import Model.IModel;
import Model.MyModel;
import algorithms.mazeGenerators.Maze;

import algorithms.search.Solution;
import javafx.scene.input.KeyEvent;

import java.io.File;
import java.util.List;
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

            else if(arg instanceof List){
                setChanged();
                notifyObservers(arg);
            }
            if (arg instanceof int[]){
                setChanged();
                notifyObservers(arg);
            }


        }
    }

    public void solveMaze() {
        model.solveGame();
    }
    public void LoadGame(String game){
        this.model.loadGame(game);
    }

    public void getSavedGames(){
        ((MyModel)this.model).getSavedGames();
    }
    public void saveGame(){
        this.model.saveGame();
    }

    public void moveCharacter(KeyEvent keyEvent) {
        MyModel.Direction direction = MyModel.Direction.NONE;
        switch (keyEvent.getCode()){
            case UP:
            case NUMPAD8:
            case DIGIT8:
                direction = IModel.Direction.UP;
                break;
            case DOWN:
            case NUMPAD2:
            case DIGIT2:
                direction = IModel.Direction.DOWN;
                break;
            case LEFT:
            case NUMPAD4:
            case DIGIT4:
                direction = IModel.Direction.LEFT;
                break;
            case RIGHT:
            case NUMPAD6:
            case DIGIT6:
                direction = IModel.Direction.RIGHT;
                break;
            case NUMPAD7:
            case DIGIT7:
                direction = IModel.Direction.UP_LEFT;
                break;
            case NUMPAD9:
            case DIGIT9:
                direction = IModel.Direction.UP_RIGHT;
                break;
            case NUMPAD3:
            case DIGIT3:
                direction = IModel.Direction.DOWN_RIGHT;
                break;
            case NUMPAD1:
            case DIGIT1:
                direction = IModel.Direction.DOWN_LEFT;
                break;
        }

        model.moveCharacter(direction);
    }
}
