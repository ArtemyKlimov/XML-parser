# �������.

XML - �������� ����� � ��������� �������:
```
<projects>
	<project name="xml">
		<member role="developer" name="Fedya"/>
		<member role="manager" name="Ivan"/>
		<member role="manager" name="Fedya"/>
		<member role="observer" name="Andrey"/>
	</project>
</projects>
```
�������� ������� - ����� ��� "projects", ������� �������� ���� ��� ��������� ��������� "project" � ������������ ��������� "name".
������ �������� �������� "name" �������� "project" - ��� �������� ������������������ �� �������� ��������� ����.
��������� ������ ��������� �� XML-��������� ������ � �������� � ����� �������� � ��������� �������:
```
<members>
    <member name="Andrey">
        <role name="observer" project="xml"/>
    </member>
    <member name="Fedya">
        <role name="developer" project="xml"/>
        <role name="manager" project="xml"/>
    </member>
    <member name="Ivan">
        <role name="manager" project="xml"/>
    </member>
</members>
```
��� �������� <project> ����� ���������� �������� ��������� "name". ������ ������� ��������� � ��������� ������. � ����� ���� ��������� "member" ������ ������ � ���� �� �������� "project" ����������� ���� �������� �������� "role", ���� �������� �������� "name", ���� � �� � ������ ������������.
� �������� ����� ���������� ����� ��������� �������� ������. �������� "member" ������ �������� � ������������������ ������� �������� ��������� "name". � ������ �������� "member" �������� "role" ������ ��������� � ������������������ ������� �������� ��������� "project", � ��� ��������� - � ������������������ ������� �������� ��������� "name".
