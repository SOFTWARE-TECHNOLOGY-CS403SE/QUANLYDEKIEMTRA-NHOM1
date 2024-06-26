using DevExpress.Data.Filtering;
using DevExpress.ExpressApp;
using DevExpress.ExpressApp.DC;
using DevExpress.ExpressApp.Model;
using DevExpress.Persistent.Base;
using DevExpress.Persistent.BaseImpl;
using DevExpress.Persistent.Validation;
using DevExpress.Xpo;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;

namespace DXApplication1.Module.BusinessObjects
{
    [DefaultClassOptions]
    [System.ComponentModel.DisplayName("CHI TIẾT VỀ BÀI KIỂM TRA")]
    //[ImageName("BO_Contact")]
    [DefaultProperty("Tenbaikiemtra")]
    [DefaultListViewOptions(MasterDetailMode.ListViewOnly, true, NewItemRowPosition.Top)]
    //[Persistent("DatabaseTableName")]
    // Specify more UI options using a declarative approach (https://documentation.devexpress.com/#eXpressAppFramework/CustomDocument112701).
    public class BAIKIEMTRA_CHITIET : BaseObject
    { // Inherit from a different class to provide a custom primary key, concurrency and deletion behavior, etc. (https://documentation.devexpress.com/eXpressAppFramework/CustomDocument113146.aspx).
        // Use CodeRush to create XPO classes and properties with a few keystrokes.
        // https://docs.devexpress.com/CodeRushForRoslyn/118557
        public BAIKIEMTRA_CHITIET(Session session)
            : base(session)
        {
        }
        public override void AfterConstruction()
        {
            base.AfterConstruction();
            // Place your initialization code here (https://documentation.devexpress.com/eXpressAppFramework/CustomDocument112834.aspx).
        }

        private BAIKIEMTRA _baikiemtra;
        [XafDisplayName("Tên bài kiểm tra"), Size(255)]
        [Association]
        public BAIKIEMTRA Baikiemtra
        {
            get { return _baikiemtra; }
            set { SetPropertyValue<BAIKIEMTRA>(nameof(Baikiemtra), ref _baikiemtra, value); }
        }

        private CAUHOI _cauhoi;
        [XafDisplayName("Câu hỏi"), Size(int.MaxValue)]
        [Association]
        public CAUHOI Cauhoi
        {
            get { return _cauhoi; }
            set { SetPropertyValue<CAUHOI>(nameof(Cauhoi), ref _cauhoi, value); }
        }

        private DAPAN _dapan;
        [XafDisplayName("Đáp án đúng"), Size(int.MaxValue)]
        [Association]
        public DAPAN Dapan
        {
            get { return _dapan; }
            set { SetPropertyValue<DAPAN>(nameof(Dapan), ref _dapan, value); }
        }

        private LOAICAUHOI _loaicauhoi;
        [XafDisplayName("Loại câu hỏi"), Size(55)]
        [Association]
        public LOAICAUHOI Loaicauhoi
        {
            get { return _loaicauhoi; }
            set { SetPropertyValue<LOAICAUHOI>(nameof(Loaicauhoi), ref _loaicauhoi, value); }
        }


    }
}