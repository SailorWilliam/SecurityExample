<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<div>
    <span><a href="/user">User list</a></span>
</div>
<br><br>
<div>
<form method="post" enctype="multipart/form-data">
    <input type="text" name="text" placeholder="Message text" />
    <input type="text" name="tag" placeholder="Message tag" />
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit">Send</button>
</form>
</div>
<h2>All messages</h2>

<form method="get" action="/main">
    <input type="text" name="filter" placeholder="Tag filter" value="${filter!}">
    <button type="submit">Find</button>
</form>
<br><br>
<#list messages as message>
<div>
    <b>${message.id}</b>
    <span>${message.text}</span>
    <span>${message.tag}</span>
    <b>${message.authorName}</b>
</div>
<#else>
    No messages
</#list>

<br><br>
<@l.logout />

</@c.page>