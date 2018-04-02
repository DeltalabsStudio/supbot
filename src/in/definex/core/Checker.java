package in.definex.core;

import in.definex.core.Action.Action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Checker
 * Special type of actions which are called when there are no actions in the action que
 * Checkers are responsible for actions like checking new messages in active/inactive group(s)
 *
 * Created by adam_ on 05-12-2017.
 */
public class Checker {

    /**
     * Max number of checkers, initialized in the constructor
     */
    private final int maxCheckingActions;
    /**
     * id of the current checker action
     */
    private int currentCheckingAction;

    /**
     * List of checker actions
     */
    private List<Action> checkerActions;

    /**
     * Callback used for debugging
     */
    private CheckerResetCallback checkerResetCallback;

    /**
     * Constructor
     * @param checkerResetCallback callback used for debugging
     * @param checkerActions list of checker actions
     */
    public Checker(CheckerResetCallback checkerResetCallback, Action... checkerActions){
        this.checkerActions = new ArrayList<>();
        addCheckers(checkerActions);
        this.maxCheckingActions = checkerActions.length;
        currentCheckingAction = 0;
        this.checkerResetCallback = checkerResetCallback;
    }

    /**
     * Add more checker actions,
     * called in init method in looper
     * @param actions checker actions
     */
    public void addCheckers(Action... actions){
        Collections.addAll(this.checkerActions, actions);
    }

    /**
     * Loops though checker actions and
     * returns the next checker action in the checkerActions list
     *
     * @return next checker action
     */
    public Action getNextChecker(){
        if(currentCheckingAction>=maxCheckingActions) {
            currentCheckingAction = 0;
            checkerResetCallback.callback();
        }
        return checkerActions.get(currentCheckingAction++);
    }

    /**
     * Interface for checker action callback
     */
    public interface CheckerResetCallback {

        void callback();

    }


}
