﻿// Date: Oct 15 2009
// Mel Llaguno
// http://www.aclaro.com
// -----------------------------------------
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
//     http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

using System.Collections.Generic;

namespace JavaSelenium.Components.Interfaces
{
    public interface IHasRowSelection<T> : IHasSelection<T> where T : Component
    {
        int SelectedRow();
        List<int> SelectedRows();
        T AddRow(int pRow);
        T AddRows(params int[] pRows);
        T RemoveRow(int pRow);
        T RemoveRows(params int[] pRows);
        string SelectedRowEvalMethod(params string [] pScriptArguments);
        string SelectedRowsEvalMethod(params string [] pScriptArguments);
    }
}
