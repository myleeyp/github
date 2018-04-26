<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>部门信息</title>
	</head>
	<body>
		<h1>部门信息 (Freemarker)</h1>
		<hr>
		<table>
			<tr>
				<th>部门编号</th>
				<th>部门名称</th>
				<th>部门所在地</th>
				<th>操作</th>
			</tr>
			<#list deptList as dept>
			<tr>
				<td>${dept.no}</td>
				<td>${dept.name}</td>
				<td>${dept.location}</td>
				<td>
					<a href="delDept?no=${dept.no}">删除</a>
				</td>
			</tr>
			</#list>
		</table>
	</body>
</html>