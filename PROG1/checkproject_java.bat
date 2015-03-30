@rem Program: checkproject
@rem Author: Markus Schordan, 2011
@rem adapted by TeM for java 2013
@rem adapted to generate my.out for checking errors (TM) - 20.09.2013

@echo off
if "%1"=="" (
  echo Usage: %~xn0 FULLJAVATYPENAME
  echo        Perform tests with program FULLJAVATYPENAME using the test files 
  echo        'JAVATYPENAME_test*.in' and 'JAVATPENAME_test*.out'.
  goto :eof
)



set javatypename=%1
set res_loc=%CD%\src\%javatypename:.=\%
set res_path=%res_loc%.java

for %%A in ("%res_path%") do (
    set res_dir=%%~dpA
    set res_file_name=%%~nA
)
set test_path=%res_dir%tests\

rem set exercisename=%resource_name:.java=%
rem set packagename=%1
rem set packagepath=%packagename:.=\%
rem set resourcepath=%~dp2
rem set startdir=%CD%

rem set packagename=%1
rem set packagepath=%packagename:.=\%
rem set resourcepath=%~dp2
rem set startdir=%CD%



set project=%1
echo -------------------------------------------------------
echo Checking tests for exercise %project%: 
echo - - - - - - - - - - - - - - - - - - - - - - - - - - - -

set passed=0
set failed=0
set total=0

for %%x in ( "%test_path%\%res_file_name%*_test*.in" ) do (call :checkone  %javatypename% "%%~dpnx" )

goto :end

:checkone
  if not exist "%~2.out" (
    echo Error: output file %~n2.out does not exist.
    exit /b
  )
 
pushd bin
  java -Duser.country=US -Duser.language=en %1 < "%~2.in" >  "%~2.my.out"
rem  java  %1 < "%~2.in" > "%~dp2tmpfile.out"
popd 
  if not errorlevel 0 (
    set /a failed+=1
    if exist %~dp2tmpfile.out del %~dp2tmpfile.out
    echo failed to run 
    goto aftertest
  )
  echo %DATE% %TIME% >> %~dp2%res_file_name%_results.txt
  fc "%~2.out" "%~2.my.out" >> "%~dp2%res_file_name%_results.txt"
  if errorlevel 1 ( 
    set /a failed+=1
    if exist "%~dp2tmpfile.out" del "%~dp2tmpfile.out"
    echo Test: %~n2: FAIL
    goto aftertest
  )
  if exist "%~dp2tmpfile.out" del "%~dp2tmpfile.out"

  set /a passed+=1
  echo Test: %~n2: PASS

:aftertest
  set /a total+=1
  goto :eof

:end
  echo -------------------------------------------------------
  echo Tests total : %total%
  echo Tests passed: %passed%
  echo Tests failed: %failed%
  echo -------------------------------------------------------


