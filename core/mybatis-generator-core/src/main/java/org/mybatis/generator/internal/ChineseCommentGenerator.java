/**
 *    Copyright 2006-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.generator.internal;


import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.TopLevelClass;


/**
 * @author hesimin 2017-07-28
 */
public class ChineseCommentGenerator extends DefaultCommentGenerator {

    public ChineseCommentGenerator() {
        super();
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        topLevelClass.addJavaDocLine("/** "); //$NON-NLS-1$

        String remarks = introspectedTable.getFullyQualifiedTable().getRemark();
        // String remarks = introspectedTable.getRemarks();
        String[] remarkLines = remarks.split(System.getProperty("line.separator"));  //$NON-NLS-1$
        for (String remarkLine : remarkLines) {
            topLevelClass.addJavaDocLine(" * " + remarkLine);  //$NON-NLS-1$
            topLevelClass.addJavaDocLine(" * " + introspectedTable.getFullyQualifiedTable());  //$NON-NLS-1$
        }

        addJavadocTag(topLevelClass, false);

        topLevelClass.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    public void addClassComment(InnerClass innerClass,
                                IntrospectedTable introspectedTable) {
        StringBuilder sb = new StringBuilder();
        innerClass.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append(" ");
        sb.append(getDateString());
        innerClass.addJavaDocLine(sb.toString());
        innerClass.addJavaDocLine(" */");
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        StringBuilder sb = new StringBuilder();
        innerClass.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append(" ");
        sb.append(getDateString());
        innerClass.addJavaDocLine(sb.toString());
        innerClass.addJavaDocLine(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {

        StringBuilder sb = new StringBuilder();

        field.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        field.addJavaDocLine(sb.toString());

        //      addJavadocTag(field, false);

        field.addJavaDocLine(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        // 非数据库字段

//        StringBuilder sb = new StringBuilder();
//
//        field.addJavaDocLine("/**");
//        sb.append(" * ");
//        sb.append(introspectedColumn.getRemarks());
//        field.addJavaDocLine(sb.toString());
//        field.addJavaDocLine(" */");
    }
}
