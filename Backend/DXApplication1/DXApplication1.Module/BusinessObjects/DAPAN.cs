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
    [System.ComponentModel.DisplayName("Đáp án")]
    //[ImageName("BO_Contact")]
    [DefaultProperty("Dapandung")]
    [DefaultListViewOptions(MasterDetailMode.ListViewOnly, true, NewItemRowPosition.Top)]
    //[Persistent("DatabaseTableName")]
    // Specify more UI options using a declarative approach (https://documentation.devexpress.com/#eXpressAppFramework/CustomDocument112701).
    public class DAPAN : BaseObject
    { // Inherit from a different class to provide a custom primary key, concurrency and deletion behavior, etc. (https://documentation.devexpress.com/eXpressAppFramework/CustomDocument113146.aspx).
        // Use CodeRush to create XPO classes and properties with a few keystrokes.
        // https://docs.devexpress.com/CodeRushForRoslyn/118557
        public DAPAN(Session session)
            : base(session)
        {
        }
        public override void AfterConstruction()
        {
            base.AfterConstruction();
            // Place your initialization code here (https://documentation.devexpress.com/eXpressAppFramework/CustomDocument112834.aspx).
        }
        private string _dapandung;
        [XafDisplayName("Đáp án đúng"), Size(int.MaxValue)]
        public string Dapandung
        {
            get { return _dapandung; }
            set { SetPropertyValue<string>(nameof(Dapandung), ref _dapandung, value); }
        }

        private string _giaithich;
        [XafDisplayName("Giải thích"), Size(int.MaxValue)]
        public string Giaithich
        {
            get { return _giaithich; }
            set { SetPropertyValue<string>(nameof(Giaithich), ref _giaithich, value); }
        }

        [DevExpress.Xpo.Aggregated, Association]
        [XafDisplayName("Chi tiết bài kiểm tra")]
        public XPCollection<BAIKIEMTRA_CHITIET> BAIKIEMTRA_CHITIETs
        {
            get { return GetCollection<BAIKIEMTRA_CHITIET>(nameof(BAIKIEMTRA_CHITIETs)); }
        }

    }
}