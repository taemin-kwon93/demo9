import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

import java.util.HashMap;
import java.util.Map;

public class Send {

    public static void main(String[] args) {
        AmazonSQS sqs = AmazonSQSClientBuilder.standard().build();

        String queueUrl = "해당 부분에 SQS Url을 입력해주시면 됩니다.";
        //AWS Lambda 환경변수를 통해 Url값을 받아오는 방법도 있습니다.

        Map<String, MessageAttributeValue> messageAttributes = new HashMap<>();

        messageAttributes.put("Name", new MessageAttributeValue()
                .withStringValue("Paul")
                .withDataType("String"));


        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody("Hello World")
                .withMessageAttributes(messageAttributes)
                .withDelaySeconds(5);

        SendMessageResult result = sqs.sendMessage(sendMessageRequest);
        System.out.println(result.getMessageId());
    }
}
