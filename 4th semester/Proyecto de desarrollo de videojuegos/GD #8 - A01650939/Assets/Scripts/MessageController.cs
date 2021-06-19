using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class MessageController : MonoBehaviour
{
    public Text message;
    public KeyCollectorController keyCollector;
    private int keys = 0;

    private void Start()
    {
        keyCollector = gameObject.GetComponent<KeyCollectorController>();
        message.text = "Collect 3 keys\n and find the hut to win";
        StartCoroutine(HideMessage(3f));
    }

    private void OnCollisionEnter(Collision other)
    {
        if (other.gameObject.tag == "Hut")
        {
            keys = keyCollector.getCollectedKeys();
            if (keys < 3)
            {
                message.text = "You need " + (3-keys) + " more keys to win";
                StartCoroutine(HideMessage(3f));
            }

            if (keys == 3)
            {
                message.text = "YOU WIN!";
                StartCoroutine(HideMessage(3f));
            }
        }

        if (other.gameObject.tag == "Key")
        {
            keys = keyCollector.getCollectedKeys();
            message.text = "Found " + keys + " keys";
            StartCoroutine(HideMessage(3f));
        }
    }

    IEnumerator HideMessage(float time)
    {
        yield return new WaitForSeconds(time);
        message.text = "";
    }
}
