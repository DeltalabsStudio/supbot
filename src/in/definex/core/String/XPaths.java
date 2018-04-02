package in.definex.core.String;

/**
 * Created by adam_ on 30-11-2017.
 */
public class XPaths {


    //get the name of the group
    private static final String groupName = "//div[@class='_25Ooe']//span[contains(text(),\"%s\")]";
    //get the bubble of chat its currently in
    public static final String inMessageBubbles = "//div[@class='Tkt2p']";

    //get the time relative from chat bubble
    public static final String bubbleToTime = ".//span[@class='_3EFt_']";
    //get the text relative from chat bubble
    public static final String bubbleToText = ".//span[contains(@class,'copyable-text')]";
    //get the author name relative from chat bubble (the bubble whihc has the author name)
    public static final String bubbleToAuthorName = ".//span[@class='_2a1Yw _1OmDL']";

    //get the input body of the chat
    public static final String inputBody = "//div[@class='_2bXVy']";
    //the send button when text is typed inside the input body
    public static final String sendButton = "//span[contains(@data-icon,'send')]";

    //get the group list item with the new chat
    public static final String newChatGroup = "//div[contains(@class,'_15G96')]/../../../../../../div[not(contains(@class,'active'))]//div[@class='_25Ooe']";
    //get the chat bubbles after the "x unread messages"
    public static final String newChatBubbles = "//div[@class='_1mq8g']//following-sibling::div//div[@class='Tkt2p']";
    //get the chat bubble before ethe "x unread messages"
    public static final String oldChatBubbles = "//div[@class='_1mq8g']//preceding-sibling::div//div[@class='Tkt2p']";

    //get the reference (@Adam) from relative from the chat bubble
    public static final String getClientReferenceFromBubble = ".//span[contains(@class,\"matched-mention\")]";
    //attribute that gives the phonenumber from the reference
    public static final String referenceAttribute = "data-jid";

    //element that appears when the whatsapp web is started (after qr code is scanned)
    public static final String autoStartReady = "//h1[contains(@class,'iHhHL')]";

    public static String getGroupNameXPath(String groupUID){
        return String.format(groupName, groupUID);
    }

}
