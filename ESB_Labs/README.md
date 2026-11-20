# Mobile Development – LAB 1 to LAB 4 (Esprit, 3 LBC-BIS)

Five complete Android Studio projects (Empty Views Activity · Java · Groovy DSL · XML views · minSdk 24 · compile/target SDK 37).

| Folder | Lab | What it contains |
|---|---|---|
| `01_LAB1_ESB` | LAB 1 | Project **ESB** (`com.example.esb`) – Empty Views Activity showing "Hello World!" |
| `02_LAB2_Part1_ESB` | LAB 2 – Part 1 | Text moved to `strings.xml` (`hello_word`), translations **French** (`values-fr`) and **Arabic** (`values-ar`), `app_name` untranslatable |
| `03_LAB2_Part2_ESB` | LAB 2 – Part 2 | Form (firstname, lastname, date of birth, city of birth) with vertical `LinearLayout` + 4 horizontal `LinearLayout`s, full-width **Validate** button wired with `android:onClick="validateAction"` (pop-up summary). **Homework:** `res/layout/tableau.xml` (TableLayout) and `res/layout/constraint.xml` (5-button ConstraintLayout) |
| `04_LAB3_ESB_2025` | LAB 3 | Project **ESB_2025** (`com.example.esb_2025`) – Figma login page: strings (en/fr/ar), colors (gray/red/pink), styles `inputstyle.xml` + `btnstyle.xml`, header image in 6 densities (`drawable-ldpi … xxxhdpi`), full `activity_main.xml` |
| `05_LAB4_ESB_2025` | LAB 4 | Same project + input checks, static credentials **Admin / Admin**, `Dashboard` activity (`Intent` + `putExtra("user", …)` + `finish()`) |

## Open and run
1. Android Studio → **Open** → pick one project folder (e.g. `05_LAB4_ESB_2025`).
2. Wait for **Gradle sync**. If asked, accept the SDK platform download (Android 17 / API 37, as in LAB 1) and/or the **AGP upgrade** suggestion.
3. Start an emulator (Device Manager) → **Run ▶**.
4. Test the languages: Emulator → Settings → System → Languages → French / العربية.
5. LAB 4 login: empty fields → "This field is required"; wrong combination → "Incorrect username and password"; `Admin` / `Admin` → Dashboard "Welcome, Admin!".

## Status of the work
- **Verified here (static checks, run on all 5 projects):** every XML file is well-formed; every `@string/@color/@drawable/@id/...` reference resolves; every string has its French and Arabic translation with matching format arguments; all views have `layout_width/height`; `onClick` methods exist; Java sources compile against stubs of the Android API using the real resource IDs; Gradle/TOML syntax parses; header image sizes match the 6 densities.
- **NOT done / could not be done here:**
  - The projects were **not compiled into an APK and not run on an emulator** (the build environment cannot reach Google's SDK/Maven servers). Expect a normal first Gradle sync, nothing else; tell me if Android Studio reports anything.
  - **LAB 1 §1–3** (install Android Studio, SDK Manager components, create the AVD) are actions on your own PC; the project part of LAB 1 is done (`01_LAB1_ESB`).
  - **Screenshots** of the emulator (needed for the Blackboard hand-in) must be taken by you.
  - **LAB 2 §2.1:** the page design "must be validated by a teacher".

## Small deliberate differences from the lab text
- Header image is **one** resource `logo` stored in each density folder (the lab's import screen would create six separate `logo_hdpi`, `logo_ldpi`… resources, which defeats the purpose of densities).
- Error TextView id: `txtformal` in LAB 3 and `txtformval` in LAB 4 (the lab uses both names; LAB 4 code needs `txtformval`).
- Dashboard button returns to a fresh login screen (the lab's bare `finish()` would close the whole app because `MainActivity` is already finished).
- Lab typos fixed ("Hello Word", the `/string>` in `log_err_cnx`); sizes are responsive (`match_parent`, 56dp) instead of fixed 390dp, as the lab note allows.
- Extra helper colors from the Figma file: `border_gray` #F2F2F2 (field border), `error_red` #F64E60 (error texts).
- LAB 2 summary is one sentence because Android 12+ cuts Toasts to two lines.
- LAB 3/4 use the Material3 *Light* theme so the pink design is not altered by dark mode.
- To preview the homework layouts: open `tableau.xml` / `constraint.xml` → Design tab (or temporarily `setContentView(R.layout.tableau)`).
