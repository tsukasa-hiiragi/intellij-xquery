/*
 * Copyright 2013-2015 Grzegorz Ligas <ligasgr@gmail.com> and other contributors
 * (see the CONTRIBUTORS file).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.intellij.xquery.annotator.comment;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.xquery.psi.XQueryMisplacedComment;

import static org.intellij.xquery.psi.XQueryTypes.EXPR_COMMENT_START;

public class MisplacedCommentHighlighter {
    public void highlight(PsiElement element, AnnotationHolder holder) {
        XQueryMisplacedComment misplacedComment = PsiTreeUtil.getTopmostParentOfType(element, XQueryMisplacedComment.class);
        if (isTheStartingElementOfMisplacedComment(element, misplacedComment)) {
            Annotation annotation = holder.createErrorAnnotation(misplacedComment, "Comments cannot be used here.");
            annotation.setHighlightType(ProblemHighlightType.GENERIC_ERROR);
        }
    }

    private boolean isTheStartingElementOfMisplacedComment(PsiElement element, XQueryMisplacedComment misplacedComment) {
        return misplacedComment != null
                && element.getNode().getElementType() == EXPR_COMMENT_START
                && element.getParent() == misplacedComment;
    }

}
