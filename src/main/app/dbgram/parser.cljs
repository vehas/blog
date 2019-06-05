(ns app.dbgram.parser
  (:require
    [medley.core :as m]
    [instaparse.core :as insta :refer-macros [defparser]]))

(defparser parse-ab "S = A B; A = 'a'+; B = 'b'+")

(def table-code "
 extend scalar @rename (ID int)
 @autoInc
 type user {
   name: string pk @fake(type: name) @autoInc
   password: string
   pet_id: int  @fk(to: pet/id)
 }
 type pet  {
   id: int @pk
   name: string
 }
")

(def table-basic
  " type user {
   id: Int
   name: String
 }
 type pet{
   owner_id: Int
  }
 ")

(def table-basic2  " type user {
   id: Int
   name: String @faker(name: \"{{name.firstName}}\")
 }
 type pet{
   owner_id: Int
  }
 ")
(defparser parse-idl "
 S      = type*
 type   = ig? <'type'> ig? table-name ig? <'{'> column* <'}'> ig?
 table-name   = iden
 column = ig? iden ig? <':'> ig? iden ig? directive?
 directive  = <'@'> iden <'('> iden <':'>  <'\"'>template-str<'\"'> <')'>
 template-str = #'[_A-Za-z0-9\\{\\}\\.]*'
 column-name = iden
 <iden>   = #'[_A-Za-z][_A-Za-z0-9]*'
 <ig>     = <#'(?:[\\s\\r\\n\\t\\u0020,\\ufeff]|#[\\t\\u0020-\\uffff]*)+'>
" :output-format :hiccup
  :auto-whitespace :comma)

(parse-idl table-basic2)
(parse-idl table-basic)

(def parse parse-idl)

(defn gen-table [table-code]
  (let [ast (parse-idl table-code)
        _   (print ::a (insta/failure? ast))
        ast-val (next ast)]
    (print ::a ast-val)
    (if (insta/failure? ast)
        []
        (->> ast-val
             (map (fn [[type  & content]]
                    (->> content
                        (group-by first)
                        (m/map-kv (fn [k v]
                                    (case k

                                      :table-name
                                      [k (get-in v [0 1])]
                                      :column
                                      [k (mapv (comp vec next) v)]))))))))))

(comment
  (js/d ::e :A)
  (gen-table table-basic))
    ;    tables (:content ast)]
    ;(->> tables
    ;     (map (fn [{:keys [type content] :as d}]
    ;            (print :cc d))))))
                ;(case type
                ;
                ;  :table
                ;  (let [content]
                ;    content)
                ;
                ;  (print  "no match : " type)))))))
;:optimize :memory)

(parse-ab "aabb")


(defparser parse-json "
JSON = ARRAY|OBJECT
<VALUE> = NULL|NUMBER|STRING|TRUE|FALSE|ARRAY|OBJECT
ARRAY = BRACKET_OPEN VALUE WHITESPACE* (COMMA WHITESPACE* VALUE)* BRACKET_CLOSE
<BRACKET_OPEN> = <'['>
<BRACKET_CLOSE> = <']'>
<WHITESPACE> = <#'\\s+'>
<COMMA> = <','>
KEY_VALUE_PAIR = STRING WHITESPACE* COLON WHITESPACE* VALUE
OBJECT = CURLY_OPEN WHITESPACE* KEY_VALUE_PAIR WHITESPACE* (COMMA WHITESPACE* KEY_VALUE_PAIR WHITESPACE*)* CURLY_CLOSE
<CURLY_OPEN> = <'{'>
<CURLY_CLOSE> = <'}'>
<COLON> = <':'>
STRING = #'\"[^\"]+\"'
NULL = <#'null'>
NUMBER = #'\\d+'
TRUE = <#'true'>
FALSE = <#'false'>
")
(parse-json "{\"a\": 1}")
