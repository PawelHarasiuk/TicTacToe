package TicTacToe;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.stereotype.Service;

/*
 to do:
 - delete GameController?
 - add logic
 - move game to the centre
 */

@Route("")
@Service
public class GameService extends VerticalLayout {
    private H1 text;
    private Button bReset;
    private final Button[] buttons;
    private final HorizontalLayout l1 = new HorizontalLayout();
    private final HorizontalLayout l2 = new HorizontalLayout();
    private final HorizontalLayout l3 = new HorizontalLayout();

    public GameService(){
        buttons = new Button[9];
        addButtons();
    }

    public void createButtons(){
        for (int i = 0; i < 9; i++) {
            buttons[i] = new Button();
            buttons[i].setHeight("200px");
            buttons[i].setWidth("200px");
        }
        bReset = new Button("Reset");
        bReset.setHeight("200px");
        bReset.setWidth("630px");
    }

    public void addButtons(){
        createButtons();
        for (int i = 0; i < buttons.length; i++) {
            if (i<3){
                l1.add(buttons[i]);
            }else if (i>5){
                l3.add(buttons[i]);
            } else {
                l2.add(buttons[i]);
            }
        }
        add(l1,l2,l3,bReset);
    }

    public void reset(){
        for (Button b : buttons) {

        }
    }

    public void addText(){

    }
}
