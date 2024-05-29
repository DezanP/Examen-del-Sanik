package com.sonic.sonicanimacion;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.input.MouseEvent;

public class HelloController {

    int currentFrameIndex;
    int totalFrames;
    final Duration frameDuration=Duration.millis(1000);
    Image[] sprites=new Image[totalFrames];

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView miImageView;
    @FXML
    private ImageView spriteImageView;
    @FXML
    private StackPane miStack;

    @FXML
    void idleAnimation(MouseEvent event){
        currentFrameIndex=0;
        totalFrames=4;
        for(int i=1;i<totalFrames;i++){
            sprites[i]=new Image(getClass().getResourceAsStream("/com/sonic/sonicanimacion/assets/animations/idle/sonicidle-"+i+".png"));
        }
        spriteImageView=new ImageView(sprites[currentFrameIndex]);
        Timeline timeline=new Timeline(
                new KeyFrame(Duration.ZERO,actionEvent -> updateFrame()),
                new KeyFrame(frameDuration)
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateFrame(){
        if(currentFrameIndex<totalFrames-1){
            currentFrameIndex+=1;
        }else{
            currentFrameIndex=0;
        }
        spriteImageView.setImage(sprites[currentFrameIndex]);
    }


}
