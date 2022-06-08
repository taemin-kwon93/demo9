import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Read {
    public static void main(String[] args) {
        AmazonSQS sqs = AmazonSQSClientBuilder.standard().build();

        String queueUrl = "해당 부분에 SQS Url을 입력해주시면 됩니다.";
        //AWS Lambda 환경변수를 통해 Url값을 받아오는 방법도 있습니다.

        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest()
                .withQueueUrl(queueUrl)
                .withWaitTimeSeconds(20)
                .withVisibilityTimeout(20)
                .withMaxNumberOfMessages(10);

        List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();

        for(Message m : messages) {
            System.out.println(m.toString());
        }
    }
}
