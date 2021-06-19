using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CardController : MonoBehaviour {
    public SpriteRenderer spriteRenderder;
    public Sprite front, back;
    public bool isShowingFront = false;
    public int sIdx, cIdx;
    public GameManagerController gameManagerController;

    private void OnMouseDown() {
        if(isShowingFront) {
            ShowBack();
            gameManagerController.GetUnselectedIdx(cIdx);
        }else{
            ShowFront();
            //Debug.Log(cIdx);
            gameManagerController.GetSlectedIdx(cIdx);
        }
    }

    public void ShowFront() {
        spriteRenderder.sprite = front;
        isShowingFront = true;
    }
    
    public void ShowBack() {
        spriteRenderder.sprite = back;
        isShowingFront = false;
    }
}
