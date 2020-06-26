package com.example.logicsimulator;

import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;

/*
    This class processes the users touch and calls methods of the GridAndMenu class.
    It acts as a buffer between the user inputs and the GridAndMenu processing.
 */
class TouchProcessor{



    private Point touchPoint;
    private GridAndMenu gridAndMenu;
    TouchProcessor(GridAndMenu gridAndMenu){
        this.gridAndMenu = gridAndMenu;
    }

    //This method takes the position where the user has touched and decides if it
    //should be processed as a button selection, circuit element selection or grid selection.
    void processTouch(MotionEvent motionEvent) {
        //First, set the touchPoint to the larger grid. This is touchPoint is
        // used more often than the small grid
        touchPoint = setTouchPoint(motionEvent.getX(), motionEvent.getY(), gridAndMenu.largeCellSize);

        //------------------------------------------------------------------------------------------

        //If there is an element at our touchPoint:
         if(gridAndMenu.elements.getElement(touchPoint)!=-1) {
                Log.d("Debugging", "Element Found at:" + touchPoint);

            //---------------------------------------------------------------------------
            //If we haven't selected an element yet:
            if(gridAndMenu.selectedElement==null) {
                Log.d("Debugging", "Action taken: Element Selected");
                gridAndMenu.elementSelect(touchPoint);


            //---------------------------------------------------------------------
            //else if we select the same element twice, then deselect
            }else if (touchPoint.x == gridAndMenu.selectedElement.x && touchPoint.y == gridAndMenu.selectedElement.y ) {
                Log.d("Debugging", "Action taken: Point unselected");
                gridAndMenu.selectedElement = null;

            //---------------------------------------------------
            //else if we have a node selected, then wire.
            }else if(gridAndMenu.selectedNode != null){
                Log.d("Debugging", "Action taken: Attempt to wire between nodes");
                Point nodeTouch = setTouchPoint(motionEvent.getX(), motionEvent.getY(), gridAndMenu.smallCellSize);
                gridAndMenu.wireTwoElements(touchPoint, nodeTouch);

            //------------------------------------------------------------------------------
            }
        }else{
            //Process the selection a grid touch.
            Log.d("Debugging", "Grid Selected at: " + touchPoint);
            gridAndMenu.gridSelect(touchPoint);
        }
    }

    private Point setTouchPoint(float touchX, float touchY, int blockSize) {
        int horizontal = getTouched(touchX, blockSize);
        int vertical = getTouched(touchY, blockSize);
        return new Point(horizontal, vertical);
    }

    private int getTouched(float touch, int blockSize){return (int)touch/ blockSize; }



}

