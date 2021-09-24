package Utils;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonHelper
{
    public static String convertSimpleWithHeader(String title, String message)
    {
        JSONObject jsonObject = new JSONObject();

        JSONObject jsonObjectSimple = new JSONObject();

        jsonObjectSimple.put("type","object");
        jsonObjectSimple.put("objectId","simple");

        JSONObject jsonBackgroundImage = new JSONObject();

        jsonBackgroundImage.put("contentDescription","");
        jsonBackgroundImage.put("smallSourceUrl","");
        jsonBackgroundImage.put("largeSourceUrl","");

        JSONArray jsonArraySources = new JSONArray();

        JSONObject jsonBackgroundImageSmall = new JSONObject();

        jsonBackgroundImageSmall.put("url","https://s3.amazonaws.com/solverpro/alexa5.jpg");
        jsonBackgroundImageSmall.put("size","small");
        jsonBackgroundImageSmall.put("widthPixels","0");
        jsonBackgroundImageSmall.put("heightPixels","0");

        JSONObject jsonBackgroundImageLarge = new JSONObject();

        jsonBackgroundImageLarge.put("url","https://s3.amazonaws.com/solverpro/alexa5.jpg");
        jsonBackgroundImageLarge.put("size","large");
        jsonBackgroundImageLarge.put("widthPixels","0");
        jsonBackgroundImageLarge.put("heightPixels","0");

        jsonArraySources.put(jsonBackgroundImageSmall);
        jsonArraySources.put(jsonBackgroundImageLarge);

        jsonBackgroundImage.put("sources",jsonArraySources);

        jsonObjectSimple.put("backgroundImage",jsonBackgroundImage);

        jsonObjectSimple.put("title",title.toUpperCase());

        JSONObject jsonTextContent = new JSONObject();

        JSONObject jsonPrimaryText = new JSONObject();

        jsonPrimaryText.put("type","PlainText");
        jsonPrimaryText.put("text",message);

        jsonTextContent.put("primaryText",jsonPrimaryText);

        jsonObjectSimple.put("textContent",jsonTextContent);
        jsonObjectSimple.put("logoUrl","https://s3.amazonaws.com/solverpro/icon_2.png");

        jsonObject.put("simpleWithHeaderTemplateData",jsonObjectSimple);

        return jsonObject.toString();
    }
}
