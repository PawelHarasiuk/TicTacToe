package TicTacToe;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Service;

@Service
public class GameService extends VerticalLayout {
    private Button
            b0 = new Button(),
            b1 = new Button(),
            b2 = new Button(),
            b3 = new Button(),
            b4 = new Button(),
            b5 = new Button(),
            b6 = new Button(),
            b7 = new Button(),
            b8 = new Button(),
            bReset = new Button();
    private Button[] buttons;

    public GameService(){
        buttons = new Button[]{
                b0,b1,b3,b4,b5,b6,b7,b8
        };
    }
}
