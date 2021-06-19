using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class WolfMovement : MonoBehaviour {
    public Transform target;
    public float speed;
    private Vector3 start, end;

    void Start() {
        if(target != null) {
            target.parent = null;
            start = transform.position;
            end = target.position;
        }
        
    }

    void FixedUpdate() {
        if(target != null) {
            float fixedSpeed = speed*Time.deltaTime;
            transform.position = Vector3.MoveTowards(transform.position, target.position, fixedSpeed);
        }

        if(transform.position == target.position){
            if(target.position == start){
                target.position = end;
                transform.localScale = new Vector3(1f, 1f, 1f);
            }else
            {
                target.position = start;
                transform.localScale = new Vector3(-1f, 1f, 1f);
            }
            //target.position = (target.position == start)?end:start;
        }
    }
}