/*
 *
 * Copyright 2016 EUROPEAN COMMISSION
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they
 * will be approved by the European Commission - subsequent
 * versions of the EUPL (the "Licence");
 *
 * You may not use this work except in compliance with the Licence.
 *
 * You may obtain a copy of the Licence at:
 *
 * https://joinup.ec.europa.eu/community/eupl/og_page/eupl
 *
 * Unless required by applicable law or agreed to in
 * writing, software distributed under the Licence is
 * distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied.
 * See the Licence for the specific language governing
 * permissions and limitations under the Licence.
 *
 */

package eu.europa.ec.grow.espd.domain.ubl;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ratoico on 12/4/15 at 10:45 AM.
 */
public interface CcvRequirementGroup extends Serializable {

    String getId();

    Boolean fulfillmentIndicator();

    List<? extends CcvCriterionRequirement> getRequirements();

    List<? extends CcvRequirementGroup> getSubgroups();

	/**
	 * Certain criteria need to have a theoretically unlimited number of requirement groups. The meta definition of
	 * these groups starts from a primary one and then gets cloned as many times as needed.
	 *
	 * @return
	 */
	boolean isUnbounded();

}
