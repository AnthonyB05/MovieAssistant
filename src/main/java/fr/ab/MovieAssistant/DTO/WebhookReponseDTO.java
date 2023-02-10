package fr.ab.MovieAssistant.DTO;

import java.io.Serializable;

public class WebhookReponseDTO implements Serializable {
    private String fulfillmentText;
    private String fulfillmentMessages;
    private String source;
    private PayloadDTO payload;
    private String outputContexts;
    private String followupEventInput;
    private String sessionEntityTypes;

    public String getFulfillmentText() {
        return fulfillmentText;
    }

    public void setFulfillmentText(String fulfillmentText) {
        this.fulfillmentText = fulfillmentText;
    }

    public String getFulfillmentMessages() {
        return fulfillmentMessages;
    }

    public void setFulfillmentMessages(String fulfillmentMessages) {
        this.fulfillmentMessages = fulfillmentMessages;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public PayloadDTO getPayload() {
        return payload;
    }

    public void setPayload(PayloadDTO payload) {
        this.payload = payload;
    }

    public String getOutputContexts() {
        return outputContexts;
    }

    public void setOutputContexts(String outputContexts) {
        this.outputContexts = outputContexts;
    }

    public String getFollowupEventInput() {
        return followupEventInput;
    }

    public void setFollowupEventInput(String followupEventInput) {
        this.followupEventInput = followupEventInput;
    }

    public String getSessionEntityTypes() {
        return sessionEntityTypes;
    }

    public void setSessionEntityTypes(String sessionEntityTypes) {
        this.sessionEntityTypes = sessionEntityTypes;
    }

    @Override
    public String toString() {
        return "WebhookReponseDTO{" +
                "fulfillmentText='" + fulfillmentText + '\'' +
                ", fulfillmentMessages='" + fulfillmentMessages + '\'' +
                ", source='" + source + '\'' +
                ", payload=" + payload +
                ", outputContexts='" + outputContexts + '\'' +
                ", followupEventInput='" + followupEventInput + '\'' +
                ", sessionEntityTypes='" + sessionEntityTypes + '\'' +
                '}';
    }
}
