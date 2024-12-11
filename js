AJS.$(document).ready(function() {
  // Create the button element
  var button = document.createElement("button");
  button.id = "my-jira-button";
  button.textContent = "My Custom Button";

  // Add button to the desired location
  var toolsSection = AJS.$("#jira-issue-tools");
  toolsSection.append(button);

  // Add click event handler
  AJS.$("#my-jira-button").on("click", function() {
    // Trigger a custom event to signal the macro to render
    AJS.trigger('my-custom-event');
  });
});





<div>
  <p>This content is displayed when the button is clicked.</p>
  </div>





<atlassian-plugin name="My Jira Button Plugin" key="my-jira-button-plugin">
  <web-resource name="my-jira-button-script" location="my-jira-button-script.js" />

  <web-macro key="my-custom-macro" name="My Custom Macro" location="templates/my-custom-macro.vm" />
</atlassian-plugin>


