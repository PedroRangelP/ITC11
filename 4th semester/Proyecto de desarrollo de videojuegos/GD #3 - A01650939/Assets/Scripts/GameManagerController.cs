using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameManagerController : MonoBehaviour {
    public Sprite[] sprites;
    public CardController[] cardsController;
    public int selected;
    private int sIndex1, sIndex2, sIndex3, cIndex, cont1=0, cont2=0, cont3=0;
    private CardController card1, card2;
    private int[] randomOrder = new int[6];

    private void Start() {
        GenerateSpriteIndex();
        AssignView();
        //Debug.Log(sIndex1+", "+sIndex2+", "+sIndex3);

    }

    private void GenerateSpriteIndex() {
        sIndex1 = Random.Range(0, sprites.Length);
        sIndex2 = Random.Range(0, sprites.Length);
        sIndex3 = Random.Range(0, sprites.Length);

        if(sIndex1==sIndex2) {
            sIndex2 = Random.Range(0, sprites.Length);
        }else if(sIndex2==sIndex3) {
            sIndex3 = Random.Range(0, sprites.Length);
        }else if(sIndex1==sIndex3) {
            sIndex3 = Random.Range(0, sprites.Length);
        }
    }

    private void GenerateRandomOrder() {
        for(int i=0; i<randomOrder.Length; i++) {
            randomOrder[i] = i;
        }

        int ran = Random.Range(0, cardsController.Length);
        for (int i = randomOrder.Length; i > 0; i--) {
            int pos = ran;
            int temp = randomOrder[i-1];
            randomOrder[i - 1] = randomOrder[pos];
            randomOrder[pos] = temp;
        }

        /*for(int i=0; i<randomOrder.Length; i++) {
            Debug.Log(randomOrder[i]);
        }*/
    }

    private void AssignView() {
        GenerateRandomOrder();

        for (int i = 0; i < cardsController.Length; i++) {
            if(cont1<2 && cardsController[randomOrder[i]].front == null) {
                cardsController[randomOrder[i]].front = sprites[sIndex1];
                cardsController[randomOrder[i]].sIdx = sIndex1;
                cont1++;
            }

            if(cont2<2 && cardsController[randomOrder[i]].front == null) {
                cardsController[randomOrder[i]].front = sprites[sIndex2];
                cardsController[randomOrder[i]].sIdx = sIndex2;
                cont2++;
            }

            if(cont3<2 && cardsController[randomOrder[i]].front == null) {
                cardsController[randomOrder[i]].front = sprites[sIndex3];
                cardsController[randomOrder[i]].sIdx = sIndex3;
                cont3++;  
            }
        }
    }
    
    void Update() {
        //Debug.Log("Selected: "+selected);
        if(card1!=null && card2!=null) {
            if(card1.isShowingFront && card2.isShowingFront) {
                if(card1.sIdx == card2.sIdx) {
                    cardsController[card1.cIdx].transform.position = new Vector3(0, -1000f, 0);
                    cardsController[card2.cIdx].transform.position = new Vector3(0, -1000f, 0);
                    card1 = null;
                    card2 = null;
                    selected = 0;
                }/*else {
                    card1.ShowBack();
                    card2.ShowBack();
                    Debug.Log("Right card is higher");
                }*/
            }
        }

        if(selected>2) {
            //Debug.Log("Extra");
            selected = 0;
            card1 = null;
            card2 = null;
            for (int i = 0; i < cardsController.Length; i++) {
                cardsController[i].ShowBack();
            }
        }       
    }

    public void GetSlectedIdx(int cIdx) {
        if(card1 == null) {
            card1 = cardsController[cIdx];
            selected +=1;
        }else if(card2 == null) {
            card2 = cardsController[cIdx];
            selected +=1;
        }else {
            selected +=1;
        }
    }

    public void GetUnselectedIdx(int cIdx) {
        if(cIdx==card1.cIdx) {
            card1 = null;
            selected -=1;
        }else if(cIdx==card2.cIdx) {
            card2 = null;
            selected -=1;
        }
    }
}
