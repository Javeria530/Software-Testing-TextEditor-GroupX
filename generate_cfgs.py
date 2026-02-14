import base64
import json
import urllib.request
import urllib.parse

# SearchWord CFG Mermaid code
searchword_mmd = """flowchart TD
  S([Start])
  Init([init getFiles = new ArrayList<>()])
  CheckLen{{"keyword.length() < 3 ?"}}
  Throw([throw IllegalArgumentException])
  DocsLoop((iterate docs))
  PagesLoop((iterate doc.getPages()))
  GetPage([pageContent = page.getPageContent()])
  Contains{{"pageContent.contains(keyword) ?"}}
  Split([words = pageContent.split])
  WordsLoop((for i = 0 to words.length))
  Match{{"words[i].equalsIgnoreCase(keyword) ?"}}
  PrefixCond{{"i > 0 ?"}}
  PrefixYes([prefixWord = words[i-1]])
  PrefixNo([prefixWord = ""])
  Add([getFiles.add result])
  BreakWords([break])
  BreakPages([break])
  End([return getFiles])

  S --> Init
  Init --> CheckLen
  CheckLen -- true --> Throw
  CheckLen -- false --> DocsLoop
  DocsLoop --> PagesLoop
  PagesLoop --> GetPage
  GetPage --> Contains
  Contains -- false --> PagesLoop
  Contains -- true --> Split
  Split --> WordsLoop
  WordsLoop --> Match
  Match -- false --> WordsLoop
  Match -- true --> PrefixCond
  PrefixCond -- true --> PrefixYes
  PrefixCond -- false --> PrefixNo
  PrefixYes --> Add
  PrefixNo --> Add
  Add --> BreakWords
  BreakWords --> BreakPages
  BreakPages --> DocsLoop
  PagesLoop -->|exhaust| DocsLoop
  DocsLoop -->|exhaust| End
"""

# Encode for Mermaid Live Editor
encoded = base64.b64encode(searchword_mmd.encode()).decode()
mermaid_url = f"https://mermaid.ink/img/{encoded}"

print("SearchWord CFG Image URL:")
print(mermaid_url)
print("\nPaginationDAO URL will be similar...")

# Download and save
try:
    response = urllib.request.urlopen(mermaid_url)
    with open("E:\\8th Semester\\Software Testing\\Assignment no 1\\Text-Editor\\SearchWord_CFG.png", "wb") as f:
        f.write(response.read())
    print("✓ SearchWord_CFG.png saved")
except Exception as e:
    print(f"Error: {e}")
