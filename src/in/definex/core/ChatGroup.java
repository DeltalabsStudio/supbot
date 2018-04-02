package in.definex.core;

import in.definex.core.Feature.Feature;
import in.definex.core.String.XPaths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * ChatGroup
 * Chat group in whatsapp with a group id
 *
 * Created by adam_ on 30-11-2017.
 */
public class ChatGroup {

    private String groupId;
    private List<Feature> myFeatures;

    /**
     * Chat item list, contains chat sent in the group
     */
    private List<ChatItem> chatItemList;
    private WebElement chatWebElement; //div on which u click to open chat

    /**
     * Constructor
     *
     * @param groupId id of the group
     * @param myFeatures list of features allowed
     * @param driver selenium web driver
     */
    public ChatGroup(String groupId, List<Feature> myFeatures, WebDriver driver) {
        this.chatItemList = new ArrayList<>();
        this.groupId = groupId;
        this.chatWebElement = driver.findElement(By.xpath(XPaths.getGroupNameXPath(groupId)));
        this.myFeatures = myFeatures;
    }

    /**
     * Constructor
     * ChatGroup with no features
     *
     * @param groupId id of the group
     * @param driver selenium web driver
     */
    public ChatGroup(String groupId, WebDriver driver){
        this(groupId, new ArrayList<>(), driver);
    }

    /**
     * Add chatItem to chatItem list
     * @param chatItem new chat item to be added
     */
    public void addChatItem(ChatItem chatItem){
        chatItemList.add(chatItem);
    }

    /**
     * chatItemList getter
     * @return chatItemList
     */
    public List<ChatItem> getChatItemList() {
        return chatItemList;
    }

    /**
     * Getter of features allowed in the group
     * @return
     */
    public List<Feature> getMyFeatures() {
        return myFeatures;
    }

    /**
     * Checks if the group has a feature
     * @param feature feature to be searched
     * @return true if group has given feature
     */
    public boolean hasFeature(Feature feature){

        for(Feature f:myFeatures){
            if(feature == f)
                return true;
        }

        return false;

    }

    /**
     * Add a new feature to the group and update it to the database
     * @param feature feature to be added
     */
    public void addFeature(Feature feature){
        this.myFeatures.add(feature);
        DatabaseManager.updateFeatures(this);
    }

    /**
     * remove an existing feature to the group and update it to the database
     * @param feature feature to be added
     */
    public void removeFeature(Feature feature){
        this.myFeatures.remove(feature);
        DatabaseManager.updateFeatures(this);
    }

    /**
     * removes all the chat items from chatItemList
     */
    public void resetChatGroup(){
        chatItemList = new ArrayList<>();
    }

    /**
     * groupId getter
     * @return group id
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * Chat Group web element getter
     * @return chat group web element
     */
    public WebElement getChatWebElement() {
        return chatWebElement;
    }
}
