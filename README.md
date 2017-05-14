# «адание.

XML - документ задан в следующем формате:
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
 орневой элемент - имеет им€ "projects", который содержит один или несколько элементов "project" с единственным атрибутом "name".
 аждое значение атрибута "name" элемента "project" - это непуста€ последовательность из строчных латинских букв.
ѕрограмма должна извлекать из XML-документа данные и выводить в новый документ в следующем формате:
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
¬се элементы <project> имеют уникальные значени€ атрибутов "name".  аждый элемент находитс€ в отдельной строке. ” любых двух элементов "member" внутри одного и того же элемента "project" различаютс€ либо значени€ атрибута "role", либо значени€ атрибута "name", либо и те и другие одновременно.
¬ выходном файле необходимо трого соблюдать заданный формат. Ёлементы "member" должны слеовать в лексикографическом пор€дке значений атрибутов "name". ¬ каждом элементе "member" элементы "role" должны следовать в лексикографическом пор€дке значений атрибутов "project", а при равенстве - в лексикографическом пор€дке значений атрибутов "name".
