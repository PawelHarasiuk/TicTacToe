package TicTacToe;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class Game extends VerticalLayout {

    private int turn;
    private final H1 text = new H1("TicTacToe");
    private final Button[] buttons = new Button[9];
    private Button bReset;
    private final HorizontalLayout l1 = new HorizontalLayout();
    private final HorizontalLayout l2 = new HorizontalLayout();
    private final HorizontalLayout l3 = new HorizontalLayout();

    public Game(){
       play();
    }

    public void createButtons(){
        for (int i = 0; i < 9; i++) {
            buttons[i] = new Button();
            buttons[i].setHeight("200px");
            buttons[i].setWidth("200px");
        }
        bReset = new Button("Reset");
        bReset.setHeight("100px");
        bReset.setWidth("630px");
    }

    public void addButtons(){
        for (int i = 0; i < buttons.length; i++) {
            if (i<3){
                l1.add(buttons[i]);
            }else if (i>5){
                l3.add(buttons[i]);
            } else {
                l2.add(buttons[i]);
            }
        }
        add(text,l1,l2,l3,bReset);
    }

    public void setButtonsAction(){
        for (Button b : buttons) {
            b.addClickListener(buttonClickEvent -> {
                b.setEnabled(false);
                b.setText(turn%2==0?"X":"O");
                text.setText(turn%2==0?"O turn":"X turn");
                checkIfGameIsOver();
                turn++;
            });
        }

        bReset.addClickListener(buttonClickEvent -> {
            for (Button b : buttons) {
                b.setText("");
                b.setEnabled(true);
            }
            text.setText("TicTacToe");
            turn=0;
        });
    }

    public void setButtonsEnabled(){
        for (Button b: buttons) {
            b.setEnabled(false);
        }
    }

    public void checkIfGameIsOver(){
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> buttons[0].getText() + buttons[1].getText() + buttons[2].getText();
                case 1 -> buttons[3].getText() + buttons[4].getText() + buttons[5].getText();
                case 2 -> buttons[6].getText() + buttons[7].getText() + buttons[8].getText();
                case 3 -> buttons[0].getText() + buttons[4].getText() + buttons[8].getText();
                case 4 -> buttons[2].getText() + buttons[4].getText() + buttons[6].getText();
                case 5 -> buttons[0].getText() + buttons[3].getText() + buttons[6].getText();
                case 6 -> buttons[1].getText() + buttons[4].getText() + buttons[7].getText();
                case 7 -> buttons[2].getText() + buttons[5].getText() + buttons[8].getText();
                default -> null;
            };

            if (line.equals("XXX")) {
                text.setText("X won!");
                setButtonsEnabled();
            }
            else if (line.equals("OOO")) {
                text.setText("O won!");
                setButtonsEnabled();
            } else if (turn>=8){
                text.setText("Draw");
            }
        }
    }

    public void play(){
        createButtons();
        addButtons();
        setButtonsAction();
    }
}
