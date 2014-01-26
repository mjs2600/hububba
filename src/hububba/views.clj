(ns hububba.views
  (:use hiccup.core
        hiccup.page
        hiccup.element))

(defn index [posts]
  (html (include-js "/js/goog/base.js" "/js/app.js")
        (javascript-tag "goog.require('hububba.core');")
        [:h1 "Hububba"]
        [:form {:id "post-form"}
         [:input {:name "post"
                  :id "title"}]
         [:textarea {:name "content"
                     :id "content"}]
         [:input {:type "button"
                  :value "Post"
                  :id "new-post"}]]
        [:div
         {:id "posts"}
         [:ul
          (for [post posts]
            [:li (:title post)])]]))
