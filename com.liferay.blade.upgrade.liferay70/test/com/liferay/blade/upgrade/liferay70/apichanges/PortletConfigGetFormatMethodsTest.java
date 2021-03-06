/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liferay.blade.upgrade.liferay70.apichanges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.liferay.blade.api.SearchResult;
import com.liferay.blade.eclipse.provider.JavaFileJDT;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("restriction")
public class PortletConfigGetFormatMethodsTest {

	final File liferayPortletFile = new File( "projects/filetests/LiferayPortlet.java" );
	final File unicodeLanguageImplFile = new File( "projects/filetests/UnicodeLanguageImpl.java" );
	PortletConfigGetFormatMethods component;

	@Before
	public void beforeTest() {
		assertTrue(liferayPortletFile.exists());
		assertTrue(unicodeLanguageImplFile.exists());
		component = new PortletConfigGetFormatMethods();
	}

	@Test
	public void unicodeLanguageImplFile() throws Exception {
		List<SearchResult> results = component.searchFile(unicodeLanguageImplFile,
				new JavaFileJDT(unicodeLanguageImplFile));

        assertNotNull(results);
        assertEquals(6, results.size());
	}

	@Test
	public void liferayPortletFile() throws Exception {
		List<SearchResult> results = component.searchFile(liferayPortletFile,
				new JavaFileJDT(liferayPortletFile));

        assertNotNull(results);
        assertEquals(3, results.size());
	}

}
