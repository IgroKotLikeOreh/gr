<table width="50%" height="100%" border="0" align="center" cellpadding="4" cellspacing="0">
    <style>
   .transparent50 {
    filter: alpha(Opacity=50);
    opacity: 0.5;
   }
  </style>
    <tr>
        <#list flags as flag>
        <td>
            <form method="post" >
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="hidden" name="flagName" value="${flag.getName()}" />
                <#if flag.nonGamer()>
                    <button type="submit" width="14%"><img src="https://mynewup.s3-ap-southeast-1.amazonaws.com/game/${flag.getName()}.png" height="100%" width="100%"/></button>
                <#else>
                    <button type="submit" width="14%"><img src="https://mynewup.s3-ap-southeast-1.amazonaws.com/game/${flag.getName()}.png" height="100%" width="100%" class="transparent50"/></button>
                </#if>
            </form>
        </td>
    </#list>
    </tr>
</table>