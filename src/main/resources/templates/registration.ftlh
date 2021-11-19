<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<h2>Add new user</h2>
${errorMessage!}
<@l.login "/registration" />
</@c.page>