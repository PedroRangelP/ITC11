using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
 
public class MakerController : MonoBehaviour
{
    [Header("Items Settings")]
    public MakerItem[] makerItems;
    public Transform itemsLayout;
    public GameObject itemPrefab;
    public SpriteRenderer itemPreview;

    [Header("Editor Objects")]
    public GameObject[] makerObjects;
    public static bool isPlaying;
    private int id;

    private void Start()
    {
        for (int i = 0; i < makerItems.Length; i++)
        {
            int j = i;
            var item = Instantiate(itemPrefab, itemsLayout);
            item.GetComponent<Image>().sprite = makerItems[j].sprite;
            item.GetComponent<Button>().onClick.AddListener(()=>{
                id = j;
                itemPreview.sprite = makerItems[j].sprite;  
            });
        }
    }

    public void Playing()
    {
        isPlaying = !isPlaying;
        if (isPlaying)
        {
            GameObject.Find("Play_button").GetComponentInChildren<Text>().text = "Regresar";
        }
        else
        {
            GameObject.Find("Play_button").GetComponentInChildren<Text>().text = "Jugar";
        }
        itemPreview.enabled = !isPlaying;

        for (int i = 0; i < makerObjects.Length; i++)
        {
            makerObjects[i].SetActive(!isPlaying);
        }
    }
    

    private void Update()
    {
        if(isPlaying)
            return;

        if (UnityEngine.EventSystems.EventSystem.current.IsPointerOverGameObject())
            return;
        
        Vector3 mouseWorldPosition = Camera.main.ScreenToWorldPoint(Input.mousePosition);
          
        RaycastHit2D targetCheck = Physics2D.Raycast(mouseWorldPosition, Vector2.up, 0.7f, 1 <<LayerMask.NameToLayer("Target"));
        if (targetCheck.collider != null)
        {
            //Debug.Log("Target");
            itemPreview.sprite = null;
        }
        else
        {
            mouseWorldPosition.x = Mathf.RoundToInt(mouseWorldPosition.x);
            mouseWorldPosition.y = Mathf.RoundToInt(mouseWorldPosition.y);
            mouseWorldPosition.z = 0;

            itemPreview.transform.position = mouseWorldPosition;
            itemPreview.sprite = makerItems[id].sprite;
        }

        if (Input.GetKeyDown(KeyCode.Mouse0))
        {
            RaycastHit2D overlapCheck = Physics2D.CircleCast(mouseWorldPosition, 0.5f, Vector2.zero);
            if (overlapCheck.collider == null)
            {
                Instantiate(makerItems[id].gameObject, mouseWorldPosition, Quaternion.identity);
            }
        }

        if (Input.GetKeyDown(KeyCode.Mouse1))
        {
            RaycastHit2D overlapCheck = Physics2D.CircleCast(mouseWorldPosition, 0.5f, Vector2.zero);
            if (overlapCheck.collider != null)
            {
                Destroy(overlapCheck.collider.gameObject);
            }
        }
    }

    private void OnMouseUp()
    {
        itemPreview.sprite = null;
    }
}
