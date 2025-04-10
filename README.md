Readme

<!-- Web panel to display content on the right context of an issue view -->
<web-panel key="AI-ROM-plugin" location="atl.jira.view.issue.right.context" weight="10">
    <!-- Context provider class for the web panel -->
    <context-provider class="com.example.plugins.PopupContextProvider"/>
    <!-- Velocity template resource for the web panel -->
    <resource type="velocity" name="view" location="templates/popup.vm"/>
</web-panel>

<!-- Web section for User License Helper in the admin applications section -->
<web-section name="User License Helper" key="ai-ram-config-websection-key" location="admin_applications_section" weight="1000">
    <label key="URL-CONFIGURATION"/>
</web-section>

<!-- Web item for Configuration under User License Helper -->
<web-item name="Configuration" key="configuration" section="admin_applications_section/ai-ram-config-websection-key" weight="1000">
    <label key="Configure-RQM-URL"/>
    <!-- Link to the configuration servlet -->
    <link linkId="configuration-Link">/plugins/servlet/issuecrud</link>
</web-item>

<!-- Internationalization resource bundle -->
<resource type="i18n" name="i18n" location="AI_Plugin_Key"/>

<!-- Servlet for Issue CRUD operations -->
<servlet name="Issue CRUD" i18n-name-key="issue-crud.name" key="issue-crud" class="com.example.plugins.tutorial.servlet.IssueCRUD">
    <description key="issue-crud.description">The Issue CRUD Plugin</description>
    <url-pattern>/issuecrud</url-pattern>
    <!-- Parameters for the servlet -->
    <param name="templateRenderer" value="templateRenderer"/>
    <param name="pluginSettingsFactory" value="pluginSettingsFactory"/>
</servlet>

<!-- Component imports for template renderer and plugin settings factory -->
<component-import key="pluginSettingsFactory" interface="com.atlassian.sal.api.pluginsettings.PluginSettingsFactory"/>
<component-import key="templateRenderer" interface="com.atlassian.templaterenderer.TemplateRenderer"/> 