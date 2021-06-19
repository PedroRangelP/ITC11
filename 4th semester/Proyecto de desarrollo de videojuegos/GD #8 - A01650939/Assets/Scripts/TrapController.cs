using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TrapController : MonoBehaviour
{
    private bool isPlayerOnTrap = false;
    private bool isActivated = false;
    private bool isHidding = false;

    private float originalPosY;

    private void Start()
    {
        originalPosY = transform.position.y;
    }

    private void Update()
    {
        if (isPlayerOnTrap == true && isActivated == false && isHidding == false){
            isActivated = true;
            StartCoroutine(DeployTrap(0.2f));
        }
    }

    IEnumerator DeployTrap(float time)
    {
        yield return new WaitForSeconds(time);
        float y = transform.position.y + 3f;
        transform.position = new Vector3(transform.position.x, y, transform.position.z);
        InvokeRepeating("HideTrap", 2f, 0.1f);
    }

    private void HideTrap()
    {
        if (transform.position.y > originalPosY)
        {
            isHidding = true;
            float y = transform.position.y - 0.03f;
            transform.position = new Vector3(transform.position.x, y, transform.position.z);
        }
        else
        {
            isHidding = false;
        }
    }

    private void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.tag == "Player")
        {
            Debug.Log("Enter trap");
            isPlayerOnTrap = true;
        }
    }

    private void OnTriggerExit(Collider other)
    {
        if (other.gameObject.tag == "Player")
        {
            Debug.Log("Exit trap");
            isPlayerOnTrap = false;
            isActivated = false;
        }
    }
}
