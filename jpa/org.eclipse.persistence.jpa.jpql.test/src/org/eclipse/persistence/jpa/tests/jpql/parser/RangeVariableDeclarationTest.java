/*******************************************************************************
 * Copyright (c) 2006, 2013 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 *
 ******************************************************************************/
package org.eclipse.persistence.jpa.tests.jpql.parser;

import org.junit.Test;

@SuppressWarnings("nls")
public final class RangeVariableDeclarationTest extends JPQLParserTest {

	@Test
	public void testBuildExpression_01() {

		String query = "SELECT e FROM Employee e";

		SelectStatementTester selectStatement = selectStatement(
			select(variable("e")),
			from(identificationVariableDeclaration(rangeVariableDeclaration("Employee", "e")))
		);

		testQuery(query, selectStatement);
	}

	@Test
	public void testBuildExpression_02() {

		String query = "SELECT e FROM Employee AS e";

		SelectStatementTester selectStatement = selectStatement(
			select(variable("e")),
			from(identificationVariableDeclaration(rangeVariableDeclarationAs("Employee", "e")))
		);

		testQuery(query, selectStatement);
	}
}