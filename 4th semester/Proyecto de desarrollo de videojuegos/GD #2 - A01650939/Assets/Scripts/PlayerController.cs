using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour {
    private float x, y, posX, posY, fixedX, fixedY, life = 100f;
    public GameObject bullet, cannon;
    private SpriteRenderer renderer;
    [SerializeField] private HealthController healthBar;
    
    void Start() {
        renderer = gameObject.GetComponent<SpriteRenderer>();
        healthBar.SetSize(life/100f);
    }

    void Update() {
        if(Input.GetKeyDown(KeyCode.Space)){
            Shoot();
        }

        posX = gameObject.transform.position.x;
        posY = gameObject.transform.position.y;
        fixedX = Mathf.Clamp(gameObject.transform.position.x, -18.53f, 18.53f);
        fixedY = Mathf.Clamp(gameObject.transform.position.y, -10.3f, 10.3f);

        x = Input.GetAxis("Horizontal")*0.05f;
        y = Input.GetAxis("Vertical")*0.05f;

        if(Mathf.Abs(posX)<=18.53f && Mathf.Abs(posY)<=10.3f) {
            gameObject.transform.Translate(new Vector3(x,y,0));
        }else{
            gameObject.transform.position = new Vector3(fixedX, fixedY, 0);
        }
        
        //Debug.Log(posX+", "+posY);
    }

    private void Shoot(){
        Instantiate(bullet, cannon.transform.position, Quaternion.identity);
    }

    private void OnCollisionEnter2D(Collision2D other) {
        if(other.gameObject.CompareTag("Meteor")) {
            renderer.color = Color.red;
            life -= 75f;
            healthBar.SetSize(life/100f);
        }

        if(other.gameObject.CompareTag("Enemy") || other.gameObject.CompareTag("EBullet")) {
            renderer.color = Color.red;
            life -= 10f;
            healthBar.SetSize(life/100f);
        }

        if(life<=0) {
            Destroy(gameObject);
        }
    }

    private void OnCollisionExit2D(Collision2D other) {
        renderer.color = Color.white;
    }
}
